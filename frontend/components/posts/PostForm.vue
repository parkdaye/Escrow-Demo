<template lang="pug">
form(@submit.prevent="onSave")
  UIInput(uniqueId="author", v-model="editedPost.author") 작성자
  UIInput(uniqueId="title", v-model="editedPost.title") 제목
  UIInput(uniqueId="thumbnail", v-model="editedPost.thumbnail") 썸네일 이미지 링크
  UIInput(controlType="textarea", uniqueId="content", v-model="editedPost.content") 콘텐츠
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
  components: { UIButton, UIInput },
  props: {
    post: { type: Object, default: () => ({}) }
  },
  data() {
    return {
      editedPost: this.post
        ? { ...this.post }
        : {
            author: '',
            title: '',
            thumbnail: '',
            content: ''
          }
    }
  },
  methods: {
    onSave() {
      console.log(this.editedPost)
    },
    onCancel() {
      this.$router.push('/mypage')
    }
  }
}
</script>

<style lang="sass" scoped>
@import "~assets/styles/config"

form
  margin-bottom: 30px

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