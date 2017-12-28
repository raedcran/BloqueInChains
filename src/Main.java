import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Bloque primerBloque = Bloque.create_genesis_block();
        ArrayList<Bloque> blockchain = new ArrayList<>();
        blockchain.add(primerBloque);
        System.out.println("Block #"+primerBloque.getIndex()+" has been added to the blockchain!");
        System.out.println("Hash: "+primerBloque.getHash());
        Bloque previous_block = blockchain.get(0);
        int num_of_blocks_to_add = 20;
        Bloque block_to_add;

        for(int i = 0;i<=num_of_blocks_to_add; i++){
            block_to_add = blockchain.get(i).next_block(previous_block);
            blockchain.add(block_to_add);
            previous_block = block_to_add;
            System.out.println("Block #"+block_to_add.getIndex()+" has been added to the blockchain!");
            System.out.println("Hash: "+block_to_add.getHash());
        }
    }
}
