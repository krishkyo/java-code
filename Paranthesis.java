import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String str=in.nextLine();
		int check=0;
		boolean res=true;
		ArrayList<Character> list=new ArrayList<Character>();
		if(str.charAt(0)!=']' || str.charAt(0)!=')' || str.charAt(0)!=')'){
		    System.out.println("working");
		    for(int j=0;j<str.length();j++){
		        if(str.charAt(j)=='[' || str.charAt(j)=='(' || str.charAt(j)=='{'){
		            list.add(str.charAt(j));
		            check++;
		        }else if(str.charAt(j)==']' || str.charAt(j)==')' || str.charAt(j)=='}'){
		            if(str.charAt(j)==')'){
		                if(list.get(check-1)=='('){
		                    list.remove(check-1);
		                    check--;
		                }else{
		                    res=false;
		                    break;
		                }
		            }else if(str.charAt(j)==']'){
		                if(list.get(check-1)=='['){
		                    list.remove(check-1);
		                    check--;
		                }else{
		                    res=false;
		                    break;
		                }
		            }else{
		                 if(list.get(check-1)=='{'){
		                    list.remove(check-1);
		                    check--;
		                }else{
		                    res=false;
		                    break;
		                }
		            }
		        }
		    }
		    if(res==true){
		        System.out.println("balanced");
		    }else{
		        System.out.println("unbalanced");
		    }
		}else{
		    System.out.println("unbalanced");
		}
	}
}

