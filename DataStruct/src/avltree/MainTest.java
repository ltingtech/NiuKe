package avltree;

public class MainTest {

	public static void main(String[] args) {
		int[] keyArr=new int[]{45,24,56,35,25,67,43,27,49};
		TreeOperation operation=new TreeOperation();
		AVLNode rootNode=null;
		boolean taller=false;
		for(int i=0;i<keyArr.length;i++){
			rootNode=operation.avlInsert(rootNode, keyArr[i], taller);
			operation.printHeadList(rootNode);
			System.out.println("************************");
		}

	}

}
