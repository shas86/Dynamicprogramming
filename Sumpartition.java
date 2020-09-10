import java.lang.*;
import java.util.ArrayList;
import java.util.List;

//import com.sample.project.codeanalysis.sample;
public class Sumpartition {
	static List <Integer> result=new ArrayList<Integer>();
	static List <Integer> ret_result=new ArrayList<Integer>();
	
	public static void main(String args[])
	{
		//int a[]= {2, 3, 4, 6};
		int a[]={1,1,3,4,7};
		int sum=0;
		for(int i=0;i<a.length;i++)
		{
			sum=sum+a[i];
		}
		
		Sumpartition s=new Sumpartition();
		
		if(sum%2==0)
		{
			sum=sum/2;
		Boolean dp[][]=new Boolean[a.length][sum+1];
		System.out.println(s.canPartition(dp,a,sum,0));
		System.out.println(ret_result);
		
		}
		else
			System.out.println("False");
	}
	public boolean canPartition(Boolean dp[][],int a[],int sum,int currentIndex)
	{
		if(currentIndex>=a.length)
			return false;
		if(sum==0)
		{
			ret_result=new ArrayList<>(result);
			return true;
			
		}
		if(dp[currentIndex][sum]!=null)
			return dp[currentIndex][sum];
		
		boolean s1=false,s2=false;
		if(a[currentIndex]<=sum)
		{
			result.add(a[currentIndex]);
			s1=canPartition(dp,a,sum-a[currentIndex],currentIndex+1);
			result.remove(result.size()-1);
		}
		s2=canPartition(dp,a,sum,currentIndex+1);
		dp[currentIndex][sum]=s1 || s2;
		return dp[currentIndex][sum];
		
	}

}


//Leetcode : https://leetcode.com/problems/partition-equal-subset-sum
