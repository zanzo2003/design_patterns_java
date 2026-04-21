package JavaCore.Datastructures.Graph.DSU;

public class UnionFind {

    private int[] rank;
    private int[] parent;

    public UnionFind( int size ){
        rank = new int[ size ];
        parent = new int[ size ];

        // initially each node is its own parent and the rank of all nodes is 0 ( since the level below it is 0 ).
        for( int i = 0 ; i < size ; i++){
            parent[ i ] = i;
            rank[ i ] = 0;
        }
    }

    // find operation with path compression - this is used to find which component is a @param node part of.
    public int find( int node ){
        if( parent[ node ] != node ){
            parent[ node ] = find( parent[ node ] ); // compressing the path for further node is get directly the component head.
        }
        return parent[ node ];
    }


    // union operation with union by rank - this operation is done to unionise 2 nodes, that is join them and form a single component like a set union.
    public void union( int node1 , int node2 ){
        int root1 = find( node1 );
        int root2 = find( node2 );

        // if both already belong to the same union, we don't need to do anything.
        if( root1 == root2 ){
            return ;
        }

        // if root1 has a higher rank that root2, then we merge root2 into root1.
        if( rank[ root1 ] > rank[ root2 ] ){
            parent[ root2 ] = root1;
        }

        // if root2 has a higher rank that root1, then we merge root1 into root2.
        else if( rank[ root1 ] < rank[ root2 ] ){
            parent[ root1 ] = root2;
        }

        // if both are equal, then we can merge anyone into the other and increase the rank of the new root by 1.
        else{
            parent[ root2 ] = root1;
            rank[ root1 ]++;
        }
    }

    public boolean connection( int node1 , int node2 ){
        return find( node1 ) == find( node2 );
    }

}
