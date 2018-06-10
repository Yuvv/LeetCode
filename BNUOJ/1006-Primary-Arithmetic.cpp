// http://www.bnuoj.com/v3/problem_show.php?pid=1006
 
#include <iostream>

using namespace std;

int main(int argc, char** argv) {
	unsigned long a, b;
	while ((cin >> a >> b) && (a != 0 || b != 0)) {
		unsigned long x, y, val = 0, t = 0;
		while (a > 0 || b > 0) {
			x = a % 10;
			y = b % 10;
			a /= 10;
			b /= 10;
			if (x + y + val > 9) {
				t++;
				val = 1;
			} else
				val = 0;
		}
		if (t > 1)
			cout << t << " carry operations." << endl;
		else if (t == 1)
			cout << t << " carry operation." << endl;
		else
			cout << "No carry operation." << endl;
	}
	
	return 0;
}

