package it.beije.xiv.esercizi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 39346
 */
public class ArrayExe {
	
    //
    public static void findMax(int arr[]){
        int maxValue=0;
        for (int el : arr){
            if (el>maxValue) {
                maxValue=el;
            }
        }
        System.out.println(maxValue);
    }
    
    public static void findMin(int arr[]){
        int minValue=arr[0];
        for (int el : arr){
            if (el<minValue) {
                minValue=el;
            }
        }
        System.out.println(minValue);
    }

       
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int arr[]= {-3,-4,2,3,67,12,35,65,15,4};
        findMax(arr);
        findMin(arr);
    }
}