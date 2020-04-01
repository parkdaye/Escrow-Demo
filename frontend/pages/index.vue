<template lang="pug">
.page-home
  section.featured-posts
    PostPreview(
      id="1",
      title="테스트 포스트1",
      thumbnail="//goo.gl/mJ5Vsy",
      content="테스트랍니다 헤헿 새벽 세시 졸리다 헿헤"
    )
    PostPreview(
      id="2",
      title="테스트 포스트2",
      thumbnail="//goo.gl/mJ5Vsy",
      content="테스트랍니다 헤헿 새벽 세시 졸리다 헿헤"
    )
            
  //- <div class="container">
  //-   <div>
  //-     <h1>홈페이지</h1>
  //-     <!-- <h2 class="subtitle">
  //-       escrow-demo-frontend
  //-     </h2>
  //-     <nuxt-link v-for="post in posts"
  //-     :key="post.title"
  //-     :to="{name: 'posts-post', params:{title:post.title, content:post.content}}"
  //-     class="button--grey">
  //-     {{post.title}}
  //-     </nuxt-link> -->
  //-   </div>
  //- </div>
</template>

<script>
import PostPreview from "@/components/posts/PostPreview";
import axios from "axios";
import { async } from "q";

export default {
  components: {
    PostPreview
  },

  async asyncData() {
    let { data } = await axios.get("http://localhost:8080/posts");
    console.log(data);
    return { posts: data };
  }
};
</script>

<style lang="sass" scoped>
@import "~assets/styles/config"

a
  text-decoration: none
  color: darken($color, 20%)
  transition: all 0.4s ease
  &:hover .post-content,
  &:active .post-content
    background-color: rgba($color, 0.26)

.featured-posts
  display: flex
  justify-content: center
  align-items: flex-start
  flex-wrap: wrap
  padding: 20px

@media (min-width: 768px)
  .intro h1
    font-size: 2rem
</style>
