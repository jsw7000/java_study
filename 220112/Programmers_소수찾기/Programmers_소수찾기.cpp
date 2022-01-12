#include <iostream>
#include <string>
#include <vector>
#include <set>

using namespace std;

void powerset(string str,int cnt);
int N;
bool* used; //해당 번호 사용 여부
string* strNum;
set<int> s; 

int prime[10000000]={1,1,}; // 길이 1~7이하인 문자열이기 때문
int solution(string numbers) {
    
    //에라토스테네스의 체
    for(int i=2;i<10000000;i++){
        if(prime[i]==1) continue;
        for(int j=i*2;j<10000000;j+=i){
            prime[j]=1;
        }
    }
    

    N = numbers.size();
    int answer = 0;
    
    used = new bool[N];
    strNum = new string[N];
    
    for(int i=0;i<N;i++){
        strNum[i] = numbers.at(i);
    }
    
    powerset("",0);
    answer = s.size();
    return answer;
}

void powerset(string str, int cnt){
    
    if(cnt>N) return;
    if(cnt==N){

        int num = atoi(str.c_str());
        
        if(prime[num]!=1){
            s.insert(num);
        }
        
        
        return; 
    }
    
    for(int i=0;i<N;i++){
        
        if(!used[i]) continue;
        
        //선택하는 경우
        used[i] = false;
        powerset(str+strNum[i],cnt+1);
        
        //선택하지 않는 경우
        used[i]=true;
        powerset(str,cnt+1);

    }
    
    
    
}