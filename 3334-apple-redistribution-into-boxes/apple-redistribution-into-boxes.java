class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum=0;
        for(int i=0;i<apple.length;i++){
            sum=sum+apple[i];
        }
        int c;
        for(int i=0;i<capacity.length;i++){
            for(int j=0;j<capacity.length-i-1;j++){
                if(capacity[j]>capacity[j+1]){
                    c=capacity[j];
                    capacity[j]=capacity[j+1];
                    capacity[j+1]=c;

                }
            }
        }
        int temp=0;
        int count =0;
        for(int i=capacity.length-1;i>=0;i--){
            if(temp<sum){
                temp=temp+capacity[i];
                count++;
            }
            

        }
        return count ;
        
    }
}