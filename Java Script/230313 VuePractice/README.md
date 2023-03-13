# Vue 연습하기

## Vue CLI 시작하기

### 참고 사이트

https://kdydesign.github.io/2019/04/22/vue-cli3-tutorial/

### Node js 설치

node js는 8.9 이상의 버전을 설치할 것

### Vue-CLI 설치

3.x 버전 설치하기

> npm i -g @vue/cli

설치된 버전 확인하기

> vue --version
>> @vue/cli 5.0.8  
3.x 버전이라는데 난 왜 이게 출력되지?

2.x Template을 가져오기 위한 vue init기능을 제공

> npm i -g @vue/cli-init

직접 프로젝트 생성. Boilerplate 로 프로젝트 초기화하는 건 은근 손이 가기 때문에...

> vue create [프로젝트이름]  
> vue init
>> vue create vue_basic  
대문자 사용 못함

대화형 커맨드로 원하는 요소들 설치하기.

> Please pick a preset
> - Manually select features

> Check the features needed for your project
> - Babel, Router, Vuex, CSS    Pre-processors, Linter/Formatter  
>> 체크는 스페이스 키로 할 수 있다.

> Choose a version of Vue.js that you want to start the project with
> - 3.x

> Use history mode for router?  (Requires proper server setup for index fallback in production)
> - y

> Pick a CSS pre-processor (PostCSS, Autoprefixer and CSS Modules are supported by default):
> - Sass/SCSS (with dart-sass)
>> 다른 선택지로는 Less, Stylus 두 가지가 있었음. 그리고 블로그에서는 Stylus를 썼는데 난 SCSS 쓰기 위해서 SCSS를 선택함.

> Pick a linter / formatter config:
> - ESLint with error prevention only
>> 코드 문법 오류 잡아주는 것 관련 세팅이다. 다른 옵션 선택하면, 문법오류 말고 코딩 스타일도 오류로 취급해서 프로그램 실행이 안 되니 조심할 것.

> Pick additional lint features:
> - Lint on save

> Where do you prefer placing config for Babel, ESLint, etc.?
> - In package.json

> Save this as a preset for future projects?
> - n

Vue ui를 통해서 프로젝트 관리하는 방법

> vue ui

Vue 실행시키기

> cd [프로젝트이름]
npm run serve

---

### Vue CLI 3 plugin 설치

axios 설치. 근데 이거 하면... 왜 오류나지?

> vue add axios  
> 혹은 vue add vue-cli-plugin-axios

---
