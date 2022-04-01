package it.beije.xiv.esercizi;

import java.util.Arrays;

public class MostRecurrent {
	public static int mostRecurrent(int[]array) {
		Arrays.sort(array);        
        int max_count = 1, res = array[0];
        int curr_count = 1;
        for (int i = 1; i < array.length; i++)
        {
            if (array[i] == array[i - 1])
                curr_count++;
            else
            {
                if (curr_count > max_count)
                {
                    max_count = curr_count;
                    res = array[i - 1];
                }
                curr_count = 1;
            }
        }
        if (curr_count > max_count)
        {
            max_count = curr_count;
            res = array[array.length - 1];
        }
        return res;
	}
	public static void main (String[]args) {
		int[]array = {1,2,2,2,4,2};
		int recurrent = mostRecurrent(array);
		System.out.println(recurrent);
	}
}
