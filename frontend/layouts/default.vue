<template>
  <div>
    <section class="intro"></section>
    <header-nav
      :nav-links="navLinks"
      @onNavMenuToggle="toggleMenu"/>
    <header-nav-menu
      :nav-links="navLinks"
      :display="displayMenu"
      @onClose="closeMenu"/>
    <nuxt/>
  </div>
</template>

<script>
import HeaderNav from "@/components/Navigation/HeaderNav";
import HeaderNavMenu from "@/components/Navigation/HeaderNavMenu";

export default {
  components: { HeaderNav, HeaderNavMenu },
  data() {
    return {
      // 모바일 메뉴 화면 표시 상태
      displayMenu: false,
      navLinks: [
        { route: "/about", text: "서비스 소개" },
        { route: "/posts", text: "게시판" },
        { route: '/mypage', text: 'MyPage' }
      ]
    };
  },
  // 컴포넌트의 커스텀 이벤트 수신 시, 처리 메서드 정의
  methods: {
    // 메뉴 토글
    toggleMenu() {
      this.displayMenu = !this.displayMenu;
    },
    // 메뉴 닫기
    closeMenu() {
      this.displayMenu = false;
    }
  }
};
</script>


<style lang="sass" scoped>
@import "~assets/styles/config"

.intro
  position: relative
  height: 200px
  margin-bottom: 20px
  padding: 30px
  background: darken($color, 40%) center
  background-size: cover
</style>