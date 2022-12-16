//Eren Can Çelik
//02210201055
package heap;

import java.util.Scanner;

public class Heap {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Aralarında virgül olacak şekilde sayıları girin = "); //lütfen boşluk kullanmayın örnek:1,2,3,4,5,6
        String str=sc.next();
        
        String[] sms=str.split(","); //splitin içindeki verdiğimiz ifadeye göre gruplar ve bunları listeye atar
        
        int [] dizi=new int[sms.length];
        for (int i=0;i<sms.length;i++){ // burada dizi string türünde olduğu için tekrar integere çevirip başka bir diziye atayacaz
            dizi[i]=Integer.parseInt(sms[i]);
        }
        int tf=kontrol(dizi); // diziyi kontrol etti
        
        if (tf==1){
            System.out.println("Evet Min heap'tir!");
            System.out.print("Dizi=");
            print(dizi);
        }
        else{
            System.out.println("Hayır Min heap değildir!");
            dizi=duzenle(dizi);
            System.out.print("Doğru ve Düzenlenmiş hali şöyledir = ");
            print(dizi);
        }
    }
    
    // 3lü min heap kontrolü doğru ise=1 verir, yanlış ise=0 verir.
    public static int kontrol(int [] array){  
        int sonuc=1;
        for(int i=0;i<array.length;i++){  //yanlış bulana kadar parrent'ın çocukarını kontrol eder. yanlış bulursa döngü kırılır ve 0 return eder.
            if(3*i+1<array.length){
                if (array[i]>array[3*i+1]){
                    sonuc=0;
                    break;
                }
            }
            if(3*i+2<array.length){
                if(array[i]>array[3*i+2]){
                    sonuc=0;
                    break;
                }
            }
            if(3*i+3<array.length){
                if(array[i]>array[3*i+3]){
                    sonuc=0;
                    break;
                }
            }
        }
        return sonuc;
    }
    
    //verilen diziyi heap olarak düzenleyip geri döndürür
    public static int [] duzenle(int [] array){
        for (int j=0;j<array.length/3;j++){
            for (int i=1;i<array.length;i++){
                if (array[(i-1)/3]>array[i]){  //parrent>child ise yer değiştir
                    int tmp=array[(i-1)/3];
                    array[(i-1)/3]=array[i];
                    array[i]=tmp;
                }
            }
        }return array;
    }
    
    //diziyi yazdırma metodu
    public static void print(int [] array){
        System.out.print("[");
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+",");
        }
        System.out.println("]");
    }
}
