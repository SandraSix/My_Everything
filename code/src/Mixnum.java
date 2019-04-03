public class Mixnum {
    public static String minnum(int[] arr){
        String result="";
        if(arr[0]==0){
                for(int i=1;i<arr.length;i++){
                    result+=nums(i,arr[i]);
                }
            }else {
                for (int j=0;j<arr.length;j++){
                    int x=0;
                    if(arr[j]!=0&&j>0){
                        result+=j;
                        result+=nums(0,arr[0]);
                        result+=nums(j,(arr[j]-1));
                        for (x=j+1;x<arr.length;x++){
                            result+=nums(x,arr[x]);
                        }
                        if (x==arr.length){
                            break;
                        }
                    }
                }
        }
        System.out.println(result);
        return result;
    }
    public static String nums(int index, int cishu){
        String s="";
        if (cishu==0){
            return "";
        }
        for (int i=0;i<cishu;i++){
            s+=index;
        }
        return s;
    }

    public static void main(String[] args) {
        int[] arr= new int[10];
        String string="0 2 0 0 0 3 0 0 1 0";
        String date="";
        String[] n1=string.split("");
        System.out.println(n1[0]);
        for (int i=0;i<n1.length;i++){
            arr[i]=Integer.valueOf(n1[i]);
            System.out.print(arr[i]);
        }

        //int[] arr=new int[]{0,2,0,0,0,3,0,0 ,1,0};
        //minnum(arr);
    }
}
