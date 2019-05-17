#include <stdio.h>
#include <stdlib.h>

int* getNum();
int sumOdd(int*);
int sumEven(int*);
int mod(int);

int main(int argc, char **argv)
{
	int i, odd, even, sum, checkDigit;

	int* originalUPC = getNum();
	odd = sumOdd(originalUPC);
	even = sumEven(originalUPC);

	sum = odd * 3 + even;
	checkDigit = mod(sum);

	printf("UPC: ");
	for (i=0;i<11;i++)
		printf("%d",originalUPC[i]);
	printf(" => %d\n", checkDigit);

	free(originalUPC);
	return 0;
}

int* getNum()
{
	long long int num;
	printf("Enter UPC number: ");
	scanf("%lld", &num);

	int* digits = malloc(sizeof(int) * 11);

	int i = 10;
	while (i >= 0)
	{
		int digit = num % 10;
		num /= 10;
		digits[i] = digit;
        i--;
	}

	return digits;
}

int sumOdd(int* UPC)
{
	int i;
	int result = 0;

	for (i = 0; i < 11; i++)
	{
		if (i % 2 == 0)
			result += UPC[i];
	}
	return result;
}

int sumEven(int* UPC)
{
	int i;
	int result = 0;

	for (i = 0; i < 11; i++)
	{
		if (i % 2 == 1)
			result += UPC[i];
	}
	return result;
}

int mod(int sum)
{
	int result = sum % 10;

	if (result != 0)
		result = 10 - result;

	return result;
}