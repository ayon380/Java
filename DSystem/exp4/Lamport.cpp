#include <bits/stdc++.h>
using namespace std;
int main()
{
    int m,n;
    cin>>m>>n;
    int mat[m][n];
    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            cin>>mat[i][j];
        }
    }
    int p1[m],p2[n];
    for(int i=0;i<m;i++)
    {
        p1[i]=i+1;
    }
    for(int i=0;i<n;i++)
    {
        p2[i]=i+1;
    }
    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(mat[i][j]==1)
            {
                p2[j]=max(p2[j],p1[i]+1)
                for(int k=j+1;k<n;k++)
                {
                    p2[k]=p2[k-1]+1;
                }
            }
            else if(mat[i][j]==-1)
            {
                p1[i]=max(p1[i],p2[j]+1);
                for(int k=i+1;k<m;k++)
                {
                    p1[k]=p1[k-1]+1;
                }
            }
        }
    }
    
    return 0;
}