<template lang="pug">
.page-mypage-create.container
  section.create-post-form
    h2.page-title 프로젝트 생성
    p 새로운 프로젝트를 생성합니다.
    form(@submit.prevent="onSave")
      UIInput(uniqueId="author", v-model="post.author") 작성자
      UIInput(uniqueId="title", v-model="post.title") 제목
      UIInput(uniqueId="thumbnail", v-model="post.thumbnail") 썸네일 이미지 링크
      UIInput(controlType="textarea", uniqueId="content", v-model="post.content") 콘텐츠
      UIButton 저장
      UIButton(
        type="UIButton",
        style="margin-left: 10px",
        styles="cancel",
        @click="onCancel"
      ) 취소
</template>

<script>
import UIButton from '@/components/ui/UIButton'
import UIInput from '@/components/ui/UIInput'

export default {
  components: {
    UIButton,
    UIInput
  },
  data() {
    return {
      post: {
        author: '',
        title: '',
        thumbnail: '',
        content: ''
      }
    }
  },
  methods: {
    onSave() {
      // 글 저장 (비동기 통신 후 백엔드 DB에 저장)
      // 추후 구현
      console.log(this.post)
    },
    onCancel() {
      this.$router.push('/mypage')
    }
  }
}
</script>

<style lang="sass" scoped>
@import "~assets/styles/config"

.page-title
  margin-bottom: 0
  font-family: Changa, Sans-Serif
  letter-spacing: -0.03em

p
  margin-top: 0
  color: rgba(#000, 0.5)
  font-size: 13px
  letter-spacing: -0.06em
</style>