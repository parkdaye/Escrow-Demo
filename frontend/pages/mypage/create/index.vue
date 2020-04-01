<template lang="pug">
.page-mypage-create.container
  section.create-post-form
    h2.page-title 프로젝트 생성
    p 새로운 프로젝트를 생성합니다.
    PostForm
</template>

<script>
import UIButton from '@/components/ui/UIButton'
import UIInput from '@/components/ui/UIInput'
import PostForm from '@/components/posts/PostForm'

export default {
  components: {
    PostForm,
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