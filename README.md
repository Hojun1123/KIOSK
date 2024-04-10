# KIOSK
3학년 1학기 기초 캡스톤 과목(음성인식 키오스크)

# 음성 인식 키오스크

## 개요
기존에 존재하는 키오스크 주문 처리 시스템에 음성 관련 기능들을 추가하여 시스템 활용에 어려움을 겪는 소비자들이 더욱 편리하게 서비스를 이용할 수 있도록 지원한다.

### 개발 필요성
무인 단말기 키오스크 시스템은 고객과 직원의 편의를 증가시키지만, 일부 사용자들에게는 이를 활용하는 데 어려움이 있습니다. 특히 고령층과 시각 장애인과 같은 그룹은 키오스크 사용에 어려움을 겪고 있습니다. 이 프로젝트는 이러한 사용자들을 고려하여 음성 관련 기능을 추가하여 주문 과정을 보다 쉽고 편리하게 만들고자 합니다.

### 목표
해당 프로젝트의 주된 목표는 음성 관련 기술 활용 및 텍스트와 버튼의 수를 최소화하여 키오스크 시스템을 간단하고 편리하게 사용하는 데 있습니다.

## 관련 라이브러리

### JLayer
MP3 음악 데이터를 재생할 수 있도록 도와주는 라이브러리
Google Cloud Speech API에서 제공하는 synthesizeText를 통하여 입력된 문자열을 MP3 파일로 변환한 후 해당 MP3 파일을 재생하는데 사용

### Google Cloud Speech API
Google Cloud Speech API는 문자열과 음성 간의 변환을 지원하는 API
음성을 텍스트로 변환하는 STT(Speech-To-Text)와 텍스트를 음성으로 변환하는 TTS(Text-To-Speech) 기능을 수행

## Flow chart
![image](https://github.com/Hojun1123/KIOSK/assets/65999992/967b1922-98d6-46f7-9b87-8c29c3e2cd72)


## Figma prototype
![image](https://github.com/Hojun1123/KIOSK/assets/65999992/956bdabf-a6fb-42e3-891f-b8e9c6480305)

## 구현
2학년 Java 수업 시간에 배웠던 Swing(JDK에서 GUI개발을 위해 기본적으로 제공하는 개발 툴킷)을 통해 키오스크 시스템의 전반적인 GUI를 개발하였다.
STT, TTS 기능을 위하여 JLayer 라이브러리와 Google Cloud Speech API를 사용하였다.
