package prefixTree;

/**
 * @author SAMSUNG
 * 前缀树
 *  功能：统计某字符串作为前缀的个数。  某字符串出现的个数。
 */
public class PrefixTree {
    
	public TriNode root;
	
	
	public static class TriNode{
		public int path; //经过此节点的个数
		public int end; //到达次节点的终点的个数。
		public TriNode[] nexts; //与此节点 连接的节点 组成的数组
		
		public TriNode() {
			// TODO Auto-generated constructor stub
			path=0;
			end=0;
			this.nexts=new TriNode[26];//假设是26个字母构成的一条边。即一个头节点，可能与26个字母的边相连。
		}
	}
	
	public static class Trie{
		private TriNode root;
		public Trie(){
			this.root=new TriNode();
		}
		
		public void insert(String str){
			char[] strChar=str.toCharArray();
			TriNode node=root;
			if(strChar!=null){
				for(int i=0;i<strChar.length;i++){
					int index=strChar[i]-'a';//相减得到索引值
					if(node.nexts[index]==null){
						node.nexts[index]=new TriNode();//不存在节点  即添加
						
					}
					node=node.nexts[index];
					node.path++;
				}
				node.end++;
			}
		}
		/**
		 * @param str
		 * @return  查找前缀词的个数   即返回最后一个字母的path 的值即可
		 */
		public int prefixNumber(String str){
			TriNode node=root;
			if(str!=null){
				char[] strChar=str.toCharArray();
				for(int i=0;i<strChar.length;i++){
					int index=strChar[i]-'a';//相减得到索引值
					if(node.nexts[index]==null){
						return 0;
					}
					node=node.nexts[index];
					
				}
				
			}
			return node.path;
			
		}
		/**搜索前缀树中单词出现的  次数   即end
		 * @param str
		 */
		public int search(String str){
			TriNode node=root;
			if(str!=null){
				char[] strChar=str.toCharArray();
				for(int i=0;i<strChar.length;i++){
					int index=strChar[i]-'a';//相减得到索引值
					if(node.nexts[index]==null){
						return 0;
					}
					node=node.nexts[index];
					
				}
				
			}
			return node.end;
			
		}
		
		
		public void delete(String str){
			TriNode node=root;
			//如果存在该节点
			if(search(str)!=0){
				char[] strChar=str.toCharArray();
				for(int i=0;i<strChar.length;i++){
					int index=strChar[i]-'a';//相减得到索引值
					if(--node.nexts[index].path==0){
						node.nexts[index]=null;
						return;
					}
					node=node.nexts[index];
					
					
				}
				node.end--;

			}
		}
		
	}
	public static void main(String[] args) {
		Trie trie = new Trie();
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		trie.insert("zuo");
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuoa");
		trie.insert("zuoac");
		trie.insert("zuoab");
		trie.insert("zuoad");
		trie.delete("zuoa");
		System.out.println(trie.search("zuoa"));
		System.out.println(trie.prefixNumber("zuo"));
}


		
	
	
	
	

}
