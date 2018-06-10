/* Transform the algebraic expression with brackets into RPN form (Reverse Polish Notation).
 * Two-argument operators: +, -, *, /, ^ (priority from the lowest to the highest), brackets ( ).
 * Operands: only letters: a,b,...,z. Assume that there is only one RPN form (no expressions like a*b*c). */


#include <iostream>
#include <stack>
#include <string>

using namespace std;


bool Compare(char x, char y);   //比较符号优先级
string Mid2Post(string mid); //中值表达式转后值表达式

int main()
{
    string mid, post;
    int total_num;
    cin >> total_num;
    while (total_num--)
    {
        cin >> mid;
        post = Mid2Post(mid);
        cout << post << endl;
    }

    return 0;
}

//中值表达式转后值表达式
string Mid2Post(string mid)
{
    string post = "";
    int x;
    stack<char> s;      //初始化栈
    s.push('#');
    for(int i=0; i<mid.length(); i++)
    {
        x = mid[i];
        switch (x)
        {
        case ')':
            while (s.top() != '(')      //反复出栈，直到遇到‘（’
            {
                post += s.top();
                s.pop();
            }
            s.pop();                        //退出‘（’
            break;
        case '+':
        case '-':
        case '*':
        case '/':
        case '^':
        case '(':
            while (Compare(s.top(), x)) //栈顶运算符与当前x比较
            {
                post += s.top();
                s.pop();                    //栈顶大于等于x时弹出
            }
            s.push(x);                    //小于时进栈
            break;
        default:
            post += x;                      //操作数直接输出
            break;
        }
    }
    while (!s.empty())
    {
        if (s.top() != '#')
        {
            post += s.top();
        }
        s.pop();
    }
    return post;
}

//比较符号优先级
bool Compare(char x, char y)
{
    switch (x)
    {
    case '(':x = 0; break;
    case '+':
    case '-':x = 1; break;
    case '*':
    case '/':x = 2; break;
    case '^':x = 3; break;
    default:
        return 0;
        break;
    }
    switch (y)
    {
    case '(':y = 4; break;
    case '+':
    case '-':y = 1; break;
    case '*':
    case '/':y = 2; break;
    case '^':x = 3; break;
    default:
        return 0;
        break;
    }
    if (x >= y)
        return 1;
    else
        return 0;
}
