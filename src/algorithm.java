public class algorithm {
    int len;
    int []dis = new int[len];

    int minimum(boolean[] bool){
        int min = Integer.MAX_VALUE;
        int index = 0;
        for(int i=0;i<len;i++){
            if(bool[i]==false && dis[i]<min){
                min = dis[i];
                index =i;
            }
        }
        return index;
    }

    void theshortest(int [][]graph, int start){
        len = graph.length;
        int []dis = new int[len];
        this.dis = dis;
        boolean [] bool = new boolean[len];

        for(int k=0;k<len; k++) {
            dis[k] = Integer.MAX_VALUE;
            bool[k] = false;
        }

        dis[start] = 0;

        for(int j=0; j<len; j++){
            int here = minimum(bool);
            bool[here] = true;

            for(int x=0; x<len; x++) {
                if (bool[x] == false && graph[here][x] != 0 && dis[x] > dis[here] + graph[here][x]) {
                    dis[x] = dis[here] + graph[here][x];
                }

            }
        }
    }

    void print(){
        System.out.println("Index:\t\t Distance:");
        for(int n=0; n<len; n++){
            System.out.println(n + "\t\t\t" + dis[n]);
        }
    }
}


