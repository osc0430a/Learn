# 교육 내용 요약

## 1. OSS CHECK LIST

### 1.1 작성 요령
1. 시트 앞단 구분에 작성된 OSS 의 공식 홈페이지 및 Github 를 방문하여 최신 Release version을 확인한다.
2. 확인된 version 확인된 날짜에 입력 및 버전 업데이트시 셀 바탕색 노란색으로 변경.
    - CVE 업데이트 내역이 있으면 보안패치 최신 version 항목도 업데이트.
3. 시트 REF 탭을 참고하여 위의 작업을 진행하면 된다.

## 2. 보안 취약점 점검

### 2.1 점검 절차 요약

#### 2.1.1 배포 및 CVE, CCE 점검 결과서 작성
- 배포 버전(brance, tag)을 각 팀에 확인 후 배포

#### 2.1.2  각 팀에 보안 취약점 공유 및 조치 요청
- 센터 공유 드라이브에 CCE, CVE 결과 공유
- 각 팀별 일정을 듣고 조치 대기

#### 2.1.3 보안 취약점 조치 확인
- 배포 버전(brance, tag)을 각 팀에 확인 후 재배포 및 점검
- 센터 공유 드라이브 파일 수정

#### 2.1.4 보안 취약점 점검 완료 공유
- 모든 취약점 조치시 까지 2 ~ 3번의 과정 반복
- 팀 공유 드라이브 파일 수정

## 3. 호환 검증

### 3.1 호환검증 절차 요약
호환검증은 아래의 순서에 따라 진행된다. 과정중 특이 사항만 아래 기재해 두었다.

#### 3.1.1 신청서 접수
- 대표 포털을 통해 기업들이 신청
- PDF 만 가능

#### 3.1.2 사전협의 회의
- 협의 일정 조절(일정 통보)
- 상호 협의

#### 3.1.3 점검 환경 요청
- 호환검증 구분에 따라 점검환경 요청(상호)

#### 3.1.4 샘플앱 및 검증 시나리오 작성 요청
- 서비스 = CCE 점검 X
- 플랫폼 = CCE 점검 X

#### 3.1.5 호환 점검
- 서비스 = CCE 점검 X
- 플랫폼 = CCE 점검 X

#### 3.1.6 산출물 확인
- 산출물 요청(아키텍처 정의서 등)

#### 3.1.7 확인서 전달 및 포털 게시
- NIA 일정에 따라 포털 게시

### 3.2 호환검증 구분
호환 검증은 크게 클라우드 플랫폼과 서비스로 구분 된다. 각 구분별 LV 및 LV 별 점검항목을 확인하자.
- 호환 검증의 경우 VM이 주 대상이다. 그렇기 때문에 Container 배포 형상은 CCE/CVE 점검 대상에서 예외이다.

#### 3.2.1 클라우드 플랫폼 구분
- LV1 :: CF, C8S 설치 버전이 해당 버전 혹은 상위 버전일 경우 OK (C8S 의 경우 고정 버전) + CCE/CVE 점검
- LV2 :: 서비스 호환 검증 시나리오 + CVE
- LV3 :: 통합인증 연동 (AP, CP 간 통합인증) 검증 시나리오 + CVE

#### 3.2.2 서비스 구분
- LV1 :: PaaS-TA 와 솔루션 연계기능 점검 (센터측에서 환경 제공) 시나리오 + 샘플앱
- LV2 :: 서비스 브로커 + 빌드팩(버전 에 따라 상이함으로 확인 필수) 연동 점검 시나리오 + 샘플앱

## 4. Openstack 환경 PaaS-TA 환경 설정
Openstack 환경에 PaaS-TA core 및 AP Portal, Monitoring 등을 배포할 때 수정해 주어야 하는 설정 파일 및 주요 설정들을 정리해보면 다음과 같다. **해당 문서에 요약된 설정은 변경해 주어야 하는 모든 설정이 아니라 변경시 주의해야 하는 설정들 임을 명심하자.**

### 4.1 openstack-vars.yml
- auth-url :: 일반적으로 엔지니어에게 요청. 현재 CCC 팀에서 사용하는 URL은 http://203.255.255.100:5000/v3/ 이다
- AZ :: 일반적으로 엔지니어에게 요청. 현재 nova 와 nova01이 있다.
- private_key :: openstack 에서 생성한 key 의 위치.
- metric_url :: PaaS-TA Monitoring Agent는 BOSH VM의 상태 정보(Metric data)를 paasta-monitoring의 InfluxDB에 전송한다. 설치 전에 paasta-monitoring의 InfluxDB IP를 metric_url로 사용하기 위해 사전에 정의해야 한다. 
- syslog_address :: Syslog Agent는 BOSH VM의 log 정보를 logsearch의 ls-router에 전송하는 역할을 한다. BOSH  logsearch의 ls-router IP를 syslog_address로 연동하기 위해 사전에 정의해야 한다.

### 4.2 openstack-cloud-config.yml

#### 4.2.1 networks
- net_id :: Openstack의 경우 Network id(IaaS 별로 상이. 예를 들어 AWS 의 경우 subnet id).
- reserved :: 예약된 IP의 목록 VM 생성시 해당 IP 를 사용하지 못하도록 설정(이미 사용중인 IP 목록이라고 생각하면 쉽다).
- static :: VM 배포시 사용하기 위해 잡아두는 설정(배포시 사용자가 사용할 영역대라고 생각하면 쉽다).
- 기타사항 :: 현재 센터에서는 Public ip 를 따로 쓰지 않고 az7 을 외부망처럼 사용

### 4.3 common-vars.yml
- bosh_client_admin_secret :: creds.yml 파일의 admin_password 항목 확인 혹은 아래의 명령 수행 결과를 입력.
```
$ echo $(bosh int ~/workspace/paasta-5.0/deployment/paasta-deployment/bosh/{iaas}/creds.yml --path /admin_password) 
```
- paasta_nats_ip :: PaaS-TA core 배포후 nats VM 의 IP 입력.
- paasta_nats_password :: PaaS-TA core 배포후 아래의 명령 수행 결과를 입력.
```
$ credhub get -n /micro-bosh/paasta/nats_password
```
- paasta_database_ips :: PaaS-TA core 배포후 database VM 의 IP 입력.

### 4.4 paasta-monitoring-vars.yml
해당 파일의 username 항목들은 수정하게 되면 해당 파일 이외에 여러 부분을 수정해야 하기 때문에 수정을 권장하지 않는다.
- system_type :: 모니터링이 배포된 환경을 입력해 주면 된다.
    + 띄어쓰기를 하지 않도록 주의
    + PaaS 한종류만 입력하는 경우 시스템 오류가 발생하니 SaaS 도 추가로 입력

## 5. 기타

### 5.1 용어 정리

#### 5.1.1 APM
Application Performance Management 의 약자. APP 의 성능을 관리하는 서비스다. 일반적으로 서비스 개발이 완료되고 테스트 단계부터 도입된다.
APM 은 크게 3가지로 구성되어 있다.
- APM server :: 데이터 수집 명령 및 데이터 분석 등 실질적인 역할을 수행하는 서버
- APM agent :: 데이터 수집을 목적으로 서비스에 설치되는 어플리케이션 서버
- APM client :: 수집 및 분석된 데이터를 사용자에게 전달하기 위한 서버

### 5.2 명령어 정리

#### 5.2.1 make 명령
리눅스 쉘 명령어로 파일관리 유틸리티다. makefile 에 기술된 대로 컴파일러에 명령하여 shell 명령이 수행되도록 한다. make 명령을 사용했을 때 얻을 수 있는 장점은 아래와 같다.
- 반복적 명령의 자동화
- 종속 구조 파악 용이
- 시간 절약

#### 5.2.2 source 명령
스크립트 파일 안의 명령어를 읽어 실행시키는 리눅스 bash 쉘의 명령어.

#### 5.2.3 bash 쉘 접속사
- & :: 해당 명령을 백그라운드에서 실행.
- ; :: 앞의 명령을 실행한 뒤 실패해도 뒤에 이어지는 명령 실행.
- && :: 앞의 명령을 실행한 뒤 성공시에만 뒤에 이어지는 명령 실행.
- \> :: 출력을 뒤에 이어지는 경로로 이동.

#### 5.2.4 find -exec 옵션
조건에 파일을 찾아서 -exec 뒤의 명령을 실행하는 옵션.