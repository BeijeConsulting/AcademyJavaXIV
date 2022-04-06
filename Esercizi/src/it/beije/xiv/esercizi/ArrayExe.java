package it.beije.xiv.esercizi;
import org.apache.commons.lang3.ArrayUtils;

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
    
    public static boolean contains(int arr[], int e){
        if (ArrayUtils.contains(arr, e)){
            return true;
        }
        else {
            return false;
        }
    }
    
    public static boolean containsObj(Object arr[], Object e){
        if (ArrayUtils.contains(arr, e)){
            return true;
        }
        else {
            return false;
        }
    }
       
    public static void isCrescente(int [] array){
        if (ArrayUtils.isSorted(array)){
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }
    }
    
    public static void media3(int [] array){
        int num=0;
        int sum=0;
        for (int el:array){
            if (el% 3 == 0){
                num+=1;
                sum+=el;
            }
        }
                System.out.println((float)sum/num);
    }
    
    public static void media(int [] array){
        int num=0;
        int sum=0;
        for (int el:array){
            
                num+=1;
                sum+=el;
        }
                System.out.println((float)sum/num);
    }
    
    public static void stampaZigZag(int [] array){
        int med = array.length/2;
        int size= array.length;
        for (int i=0; i<=med; i++){
            System.out.println(array[i]);
            System.out.println(array[size-1]);  
            size-=1;
        }}
    
    public static void addStr(String[] array, String s ){
        int i=0;
        String[] newArr= new String[array.length+1];
        for (String el: array){
            newArr[i]=el;
            i+=1;
        }
        newArr[i]=s;
        for (String el: newArr){
                    System.out.println(el);
        }
        }
    
    public static void mostRecurrent(int [] array){
        int max=0;
        int numMax=0;
        int valueOfMax=0;
        for (int i=0; i<array.length; i++){
            for (int j=i+1; j<array.length; j++){
                if (array[i]==array[j]){
                    max=max+1;
                }
                if (max>numMax){
                    numMax=max;
                    valueOfMax=array[i];
                }
            }
        }
        if (max==0) {
            System.out.println("\n" +"tutti i num occorrono 1 volta");
        }
        else{
        System.out.println("\n" +"numero most recurrent: "+valueOfMax);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] arrStr= {"ciao", "sono", "Giuseppe"};
        String s= "Sancesario";
        int arrOrd[]={1,2,3,4,5,6,7};
        int arr[]= {1,2,3,4,2,2,4,4,4,4,5,5,5,5,5,5,5,5,5,5,5,5,5,4,5,1,0,0};
        Object arrObj[] = {1,2,4, "cane"};
        int e=2;
        findMax(arr);
        findMin(arr);
        boolean boolContain = contains(arr, 2);
        System.out.println(boolContain);
        boolean boolContainObj = containsObj(arrObj, "cane");
        System.out.println(boolContainObj);
        isCrescente(arrOrd);
        mostRecurrent(arr);
        media3(arrOrd);
        stampaZigZag(arrOrd);
        media(arrOrd);
        addStr(arrStr, s);
    }
    //
}
