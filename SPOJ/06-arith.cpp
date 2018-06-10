/* input an expression (+, -, *)
 * output the formatted calculation procedure.
 */
#include <iostream>
#include <vector>
#include <iomanip>

using namespace std;


vector<string> add(vector<string> vec, int* max_len) {
    string result = "";
    short carry = 0;
    char sg_result;
    int v0i = vec[0].length()-1, v1j=vec[1].length()-1;

    while(v1j > 0) {
        sg_result = vec[0][v0i] + vec[1][v1j] - '0' + carry;
        if(sg_result > '9') {
            sg_result -= 10;
            carry = 1;
        } else {
            carry = 0;
        }
        result = sg_result + result;

        v0i--;
        v1j--;
    }
    
    // add other numbers in vec[0]
    if(v0i >= 0) {
        result = vec[0].substr(0, v0i + 1) + result;
    }
    if(*max_len < result.length()) {
        *max_len = result.length();
    }
    vec.push_back(result);
    return vec;
}

vector<string> sub(vector<string> vec, int* max_len) {
    string result = "";
    short borrow = 0;
    char sg_result;
    int v0i = vec[0].length()-1, v1j=vec[1].length()-1;

    while(v1j > 0) {
        sg_result = vec[0][v0i] - borrow - vec[1][v1j] + '0';
        if(sg_result < '0') {
            sg_result += 10;
            borrow = 1;
        } else {
            borrow = 0;
        }
        result = sg_result + result;

        v0i--;
        v1j--;
    }
    
    // continue to sub
    while(borrow) {
        sg_result = vec[0][v0i] - borrow;
        if(sg_result < '0') {
            sg_result += 10;
            borrow = 1;
        } else {
            borrow = 0;
        }
        result = sg_result + result;

        v0i--;
    }
    // add other numbers in vec[0]
    if(v0i >= 0) {
        result = vec[0].substr(0, v0i) + sg_result + result;
    }
    // delete triming '0'
    for(int i=0; i<result.length(); i++) {
        if(result[i] != '0') {
            result = result.substr(i, result.length()-i);
        }
    }

    // if(*max_len < result.length()) {
    //     *max_len = result.length();
    // }
    vec.push_back(result);
    return vec;
}

vector<string> mlt(vector<string> vec, int* max_len) {
    string result;
    string suffix_blank = "";
    short carry = 0;
    char sg_result;
    int v1j=vec[1].length()-1, v0i;
    while(v1j > 0) {
        result = "";
        for(int v0i = vec[0].length()-1; v0i>=0; v0i--) {
            if (vec[1][v1j] == '0') {
                result = '0';
                break;
            }
            sg_result = (vec[0][v0i] - '0') * (vec[1][v1j] - '0') + carry;
            if(sg_result >= 10) {
                result = (char)('0' + sg_result % 10) + result;
                carry = sg_result / 10;
            } else {
                result = (char)('0' + sg_result) + result;
                carry = 0;
            }
        }
        // add carry
        if(carry > 0) {
            result = (char)('0' + carry) + result;
            carry = 0;
        }
        result += suffix_blank;
        vec.push_back(result);
        suffix_blank += " ";
        v1j--;
    }
    
    // calculate final result
    if (vec.size() == 4) {
        if(*max_len < result.length()) {
            *max_len = result.length();
        }
        return vec;
    }
    result = vec[3];
    for(int i=4; i<vec.size(); i++) {
        v0i = result.length() - 1;
        v1j = vec[i].length() - 1;
        carry = 0;
        while(v0i >=0 && v1j >=0) {
            sg_result = result[v0i] + vec[i][v1j] - '0' + carry;
            if(sg_result < '0') {
                sg_result += 16;
                carry = 0;
            } else if(sg_result > '9') {
                sg_result -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            result[v0i] = sg_result;

            v0i--;
            v1j--;
        }
        // add other numbers in vec[i] or result
        while(v0i >= 0) {
            sg_result = result[v0i] + carry;
            if(sg_result > '9') {
                sg_result -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            result[v0i] = sg_result;
            v0i--;
        }
        while(v1j >= 0) {
            sg_result = vec[i][v1j] + carry;
            if(sg_result > '9') {
                sg_result -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            result = sg_result + result;
            v1j--;
        }
        if(carry > 0) {
            result = (char)(carry + '0') + result;
            carry = 0;
        }
    }

    if(*max_len < result.length()) {
        *max_len = result.length();
    }

    // add seprator
    string tmp_str(*max_len, '-');
    vec.push_back(tmp_str);
    
    vec.push_back(result);
    return vec;
}

int main(int argc, char** argv) {
    int total;
    string exp;
    vector<string> vec;
    int max_len = 0;

    cin >> total;
    while(total--) {
        cin >> exp;
        // split expression
        for(int i=0; i<exp.length(); i++) {
            if(exp[i] == '+' || exp[i] == '-' || exp[i] == '*') {
                vec.push_back(exp.substr(0, i));
                vec.push_back(exp.substr(i, exp.length() - i));
                if(exp.length() - i > i) {
                    max_len = exp.length() - i;
                } else {
                    max_len = i;
                }
                break;
            }
        }
        // add seprator
        string tmp_str(max_len, '-');
        vec.push_back(tmp_str);

        // do calculate
        switch(vec[1][0]) {
        case '+':
            vec = add(vec, &max_len);
            break;
        case '-':
            vec = sub(vec, &max_len);
            break;
        case '*':
            vec = mlt(vec, &max_len);
            break;
        default:
            break;
        }

        // output the result
        size_t blank_pos;
        for(string i: vec) {
            blank_pos = i.find_first_of(' ');
            if(blank_pos < i.length()) {
                // trim end blanks
                cout << right << setw(max_len - i.length() + blank_pos) << setfill(' ') << i.substr(0, blank_pos) << endl;
            } else {
                cout << right << setw(max_len) << setfill(' ') << i << endl;
            }
        }
        vec.clear();
        cout << endl;
    }

    return 0;
}