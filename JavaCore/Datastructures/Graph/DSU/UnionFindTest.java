package JavaCore.Datastructures.Graph.DSU;

public class UnionFindTest {

    public static void main( String[] args ){
        UnionFind union = new UnionFind( 4 );
        int[][] graph = {{0,1},{2,3}};

        for( int[] edge : graph ){
            union.union( edge[ 0 ] , edge[ 1 ] );
        }

        System.out.println( "Is node 0 and 1 connected ? " + union.connection( 0 , 1 ) );
        System.out.println( "Is node 1 and 2 connected ? " + union.connection( 1 , 2 ) );
    }
}
