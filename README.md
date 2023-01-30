# jpa_elearning

인프런과 같은 동영상 강의 홈페이지를 구현하는데 필요한 벡엔드 서버 개발
 
 
 # api 명세
 

  /user/** 형식으로 구성된 uri 는 role 이 user 여야 합니다. 따라서 로그인후 토큰을 받은뒤에 Bearer token 값에
토큰을 넣어주어야 정상적으로 동작합니다.

register 로 회원가입시에는 처음 단계이므로 토큰이 필요없습니다.
 
 # member  

 <details markdown="1">
<summary> register</summary>
 

 ## /register

![image](https://user-images.githubusercontent.com/42957005/215473779-0e6b6ab9-5165-403b-8601-b1f5332750d3.png)
 
</details>


 <details markdown="1">
<summary> delete</summary>
 

 ## /user/delete/{account}

 ![화면 캡처 2023-01-30 205125](https://user-images.githubusercontent.com/42957005/215470082-f5961d1e-a361-4d6a-95d7-c0dedaf0fdbc.png)
 
</details>

 

 <details markdown="1">
<summary> login</summary>
 

 ## /login

![image](https://user-images.githubusercontent.com/42957005/215474246-5ec1e7ba-4214-43d9-a50f-04b598bdbff3.png) 
</details>


 <details markdown="1">
<summary> get all user</summary>
 

 ## /user/getusers

![image](https://user-images.githubusercontent.com/42957005/215474807-a7fa38c8-7ec6-49cc-b9f9-12b05bf8e5ad.png)
</details>








 <details markdown="1">
<summary>modify user password</summary>
 

 ## /user/modify/{account}
request parameter : string password 
 
![image](https://user-images.githubusercontent.com/42957005/215475607-c8cace69-a747-454c-a7c6-549f5293060f.png)
![image](https://user-images.githubusercontent.com/42957005/215475390-2a10c67d-ef19-4c88-b231-4675d660311a.png)

</details>







 <details markdown="1">
<summary>find user by account</summary>
 

 ## /user/get/{account}
  
![image](https://user-images.githubusercontent.com/42957005/215475988-287a26ec-8c2d-4048-9937-d7ba4b251fc7.png)

</details>
 





 <details markdown="1">
<summary>add admin authority</summary>
 

 ## /user/toadmin/{email}
  
![image](https://user-images.githubusercontent.com/42957005/215476467-ef885108-a6fb-47cc-b703-530ab0e6579d.png)

</details>
 











# file
 <details markdown="1">
<summary> file </summary>
 
 get 

</details>
