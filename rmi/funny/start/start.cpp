// start.cpp : コンソール アプリケーション用のエントリ ポイントの定義
//

#include "stdafx.h"
#include <windows.h>

int main(int argc, char* argv[])
{	
	STARTUPINFO si = { sizeof(si) };
	PROCESS_INFORMATION pi;
	char cmd[1024];


	memset(cmd,0x00,sizeof(cmd));

	sprintf(cmd,"rmiregistry.exe");
	printf("%s\n",cmd);
	
	if(CreateProcess(NULL,cmd, NULL, NULL,false, DETACHED_PROCESS, NULL, NULL, &si, &pi))
	{
		
		printf("rmiregistry started Ok!\n");
	}
	else
	{
		printf("rmiregistry started Error!\n");
		return 1;
	}


	sprintf(cmd,"java RemoteCmdServer");
	printf("%s\n",cmd);

	if(CreateProcess(NULL,cmd, NULL, NULL,false, DETACHED_PROCESS, NULL, NULL, &si, &pi))
	{
		
		printf("rmi server started Ok!\n");
	}
	else
	{
		printf("rmi server started Error!\n");
		return 1;
	}



	return 0;
}

