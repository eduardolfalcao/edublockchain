package br.com.edublockchain.model;

public class Blockchain {
	
	private static Blockchain blockchain;
	
	private Block initialBlock = null, lastBlock = null;
	private int size;
	
	private Blockchain() {
		this.size = 0;
	}
		
	public static Blockchain getInstance() {
		if(Blockchain.blockchain == null) {
			Blockchain.blockchain = new Blockchain();
		}
		return Blockchain.blockchain;
	}
	
	public void appendBlock(Block block) {
		if(this.initialBlock == null) {
			this.initialBlock = block;
		}
		this.lastBlock = block;
		size++;
	}
	
	public Block getInitialBlock() {
		return initialBlock;
	}
	
	public Block getLastBlock() {
		return lastBlock;
	}
	
	public int getSize() {
		return size;
	}
	
	@Override
	public String toString() {
		String out = "#########################\n";
		Block aux = this.lastBlock;
		while(aux != null && aux != this.initialBlock) {
			out += aux.toString()+"\n";
			out += "#########################\n";
			aux = aux.getPreviousBlock();
		}
		out += "\n\n";
		return out;			
	}

}
