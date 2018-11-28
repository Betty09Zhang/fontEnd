package prefixTree;

/**
 * @author SAMSUNG
 * ǰ׺��
 *  ���ܣ�ͳ��ĳ�ַ�����Ϊǰ׺�ĸ�����  ĳ�ַ������ֵĸ�����
 */
public class PrefixTree {
    
	public TriNode root;
	
	
	public static class TriNode{
		public int path; //�����˽ڵ�ĸ���
		public int end; //����νڵ���յ�ĸ�����
		public TriNode[] nexts; //��˽ڵ� ���ӵĽڵ� ��ɵ�����
		
		public TriNode() {
			// TODO Auto-generated constructor stub
			path=0;
			end=0;
			this.nexts=new TriNode[26];//������26����ĸ���ɵ�һ���ߡ���һ��ͷ�ڵ㣬������26����ĸ�ı�������
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
					int index=strChar[i]-'a';//����õ�����ֵ
					if(node.nexts[index]==null){
						node.nexts[index]=new TriNode();//�����ڽڵ�  �����
						
					}
					node=node.nexts[index];
					node.path++;
				}
				node.end++;
			}
		}
		/**
		 * @param str
		 * @return  ����ǰ׺�ʵĸ���   ���������һ����ĸ��path ��ֵ����
		 */
		public int prefixNumber(String str){
			TriNode node=root;
			if(str!=null){
				char[] strChar=str.toCharArray();
				for(int i=0;i<strChar.length;i++){
					int index=strChar[i]-'a';//����õ�����ֵ
					if(node.nexts[index]==null){
						return 0;
					}
					node=node.nexts[index];
					
				}
				
			}
			return node.path;
			
		}
		/**����ǰ׺���е��ʳ��ֵ�  ����   ��end
		 * @param str
		 */
		public int search(String str){
			TriNode node=root;
			if(str!=null){
				char[] strChar=str.toCharArray();
				for(int i=0;i<strChar.length;i++){
					int index=strChar[i]-'a';//����õ�����ֵ
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
			//������ڸýڵ�
			if(search(str)!=0){
				char[] strChar=str.toCharArray();
				for(int i=0;i<strChar.length;i++){
					int index=strChar[i]-'a';//����õ�����ֵ
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
