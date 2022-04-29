/**************************************************************
* Name        : Tour Bus Ticket Kiosk 
* Author      : Marissa Ranatunga
* Created     : 4/29/2022
* Course      : CIS 152 Data Structures
* Version     : 1.0
* OS          : Windows 
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : This program allows the user to purchase tour bus tickets and select the number of tickets they want
*               Input: Desired bus level, and number of desired tickets to purchase
*               Output: The output will show the user a receipt of their purchase 
* I have not used unauthorized source code, either modified or 
* unmodified. I have not given other fellow student(s) access to
* my program.         
***************************************************************/
package busStation;

public class DatesOfOperation {

	void merge(int arr[], int l, int m, int r)

	{
		// Find sizes of two subarrays to be merged

		int n1 = m - l + 1;

		int n2 = r - m;

		/* Create temp arrays */

		int L[] = new int[n1];

		int R[] = new int[n2];

		/* Copy data to temp arrays */

		for (int i = 0; i < n1; ++i)

			L[i] = arr[l + i];

		for (int j = 0; j < n2; ++j)

			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays

		int i = 0, j = 0;

		// Initial index of merged subarray array

		int k = l;

		while (i < n1 && j < n2) {

			if (L[i] <= R[j]) {

				arr[k] = L[i];

				i++;

			}

			else {

				arr[k] = R[j];

				j++;

			}

			k++;

		}

		/* Copy remaining elements of L[] if any */

		while (i < n1) {

			arr[k] = L[i];

			i++;

			k++;

		}

		/* Copy remaining elements of R[] if any */

		while (j < n2) {

			arr[k] = R[j];

			j++;

			k++;

		}

	}

	void sort(int DateArr[], int l, int r)

	{

		if (l < r) {

			// Find the middle point

			int m = l + (r - l) / 2;

			// Sort first and second halves

			sort(DateArr, l, m);

			sort(DateArr, m + 1, r);

			// Merge the sorted halves

			merge(DateArr, l, m, r);

		}

	}

}
