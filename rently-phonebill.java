import java.util.*;
class Details{
    String time;
    String number;
    int numberInInt;
    int amount;
    int TotalTime;
    int TotalTimeInSec;
    int k;
    Details(String time,String number){
        this.time=time;
        this.number=number;
    }
    public void check(){
        int tempnum=0,HourInMin=0,MinInMin=0,Seconds=0;
        String[] temp=time.split(":",0);
        for(String w:temp){
            if(tempnum==0){
                int tempnum1=Integer.parseInt(w);
                HourInMin=tempnum1*60;
                tempnum++;
            }else if(tempnum==1){
                int tempnum1=Integer.parseInt(w);
                if(tempnum1>59){
                    MinInMin=tempnum1-60;
                    HourInMin=HourInMin+60;
                }else
                    MinInMin=tempnum1;
                tempnum++;
            }else{
                int tempnum1=Integer.parseInt(w);
                if(tempnum1>59){
                    Seconds=tempnum1-60;
                    MinInMin+=1;
                }else
                    Seconds=tempnum1;
            }
        }
        this.TotalTime=HourInMin+MinInMin;
        this.TotalTimeInSec=(HourInMin*60*60)+(MinInMin*60)+Seconds;
        if(TotalTimeInSec>=300){
            if(Seconds>0){
                TotalTime++;
            }
            amount=150*TotalTime;
        }else{
            amount=TotalTimeInSec*3;
        }
        String s2="";
        String[] arr=number.split("-",0);
        for(String w:arr){
            s2+=w;
        }
        numberInInt=Integer.parseInt(s2);
    }
}
public class Main
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String str=in.nextLine();int j=0;
		String[] arr=str.split(",",0);
		ArrayList<String> phonebook=new ArrayList<String>();
		for(String w:arr){
		    String[] brr=w.split(" ",0);
		    for(String x:brr)
		        phonebook.add(x);
		}
		Details user[]=new Details[phonebook.size()/2];
		for(int i=0;i<(phonebook.size()/2);i++){
		    user[i]=new Details(phonebook.get(j),phonebook.get(j+1));j+=2;
		}
		for(int i=0;i<(phonebook.size()/2);i++){
		    user[i].check();
		}
		for(int i=0;i<(phonebook.size()/2)-1;i++){
		    for(int s=i+1;s<(phonebook.size()/2);s++){
		        if(user[i].number.equals(user[s].number)){
		                user[i].TotalTimeInSec=user[i].TotalTimeInSec+user[s].TotalTimeInSec;
		                user[i].amount=user[i].amount+user[s].amount;
		                user[s].TotalTimeInSec=user[i].TotalTimeInSec;user[s].amount=user[i].amount;
		        }
		    }
		}
		int maxTime=user[0].TotalTimeInSec,numValue=0;
		for(int i=1;i<(phonebook.size()/2);i++){
		    if(maxTime<user[i].TotalTimeInSec){
		        maxTime=user[i].TotalTimeInSec;
		        numValue=i;
		    }else if(maxTime==user[i].TotalTimeInSec){
		        if(user[numValue].numberInInt>user[i].numberInInt){
		            maxTime=user[i].TotalTimeInSec;
		            numValue=i;
		        }
		    }
		}
		user[numValue].amount=0;
		for(int i=numValue+1;i<(phonebook.size()/2);i++){
		    if(user[numValue].numberInInt==user[i].numberInInt)
		        user[i].amount=user[numValue].amount;
		}
		int sum=0;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<(phonebook.size()/2);i++)
            map.put(user[i].numberInInt, user[i].amount);
        for(Map.Entry<Integer, Integer> data : map.entrySet()) {
            System.out.println("Phone Number: " + data.getKey() + " Amount : " + data.getValue()+" cents");
            sum+=data.getValue();
            if(data.getValue()==0)
                System.out.println("Offer applied to above number");
        }
        System.out.println();
        System.out.println("Total Amount to be paid: "+sum +" cents");
	}
}




