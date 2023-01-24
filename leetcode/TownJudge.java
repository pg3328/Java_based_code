public class TownJudge {
    public int[][] adjacencyMatrix;

    public int findJudge(int n, int[][] trust) {
        int[][] adjacencyMatrix  = new int[n+1][n+1];
        for(int i=0;i< trust.length;i++){
            adjacencyMatrix[trust[i][0]][trust[i][1]]=1;
        }
        for(int i=1;i< adjacencyMatrix.length;i++){
            int flag=0;
            for(int j=1;j<adjacencyMatrix[i].length;j++){
                if(adjacencyMatrix[i][j]==1){
                    flag=1;
                }
            }
            if(flag==0) return i;
        }
        return -1;
    }
    public static void main(String[]args){
        TownJudge tj = new TownJudge();
        int[][] input = new int[][]{{1,3},{2,3},{3,1}};
        System.out.println(tj.findJudge(3,input));
    }

}
