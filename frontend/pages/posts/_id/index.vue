<template lang="pug">
  .page-single-post
    section.post
      h1.post-title {{ loadedPost.title }}
      .post-info
        span.post-author {{ loadedPost.author }}
        span.post-data {{ loadedPost.updatedDate }}
      img.post-image(:src="loadedPost.thumbnail", alt, width="600")
      p.post-content {{ loadedPost.content }}
    section.post-feedback
      p
        | 안냐세여 포스트임돠
</template>

<script>
export default {
  asyncData({ route }, callback) {
    setTimeout(() => {
      callback(new Error(), {
        // 1초 지연된 데이터 로드 시뮬레이션
        loadedPost: {
          id: "1",
          title: "테스트",
          author: "daye",
          updatedDate: new Date().toLocaleString(),
          thumbnail: "//goo.gl/mJ5Vsy",
          content:
            "테스트스테스테스트트"
        }
      });
    }, 1000);
  }
};
</script>

<style lang="sass" scoped>
.page-single-post
	padding: 30px
	text-align: center
	box-sizing: border-box

.post
	width: 100%

.post-title
	margin: 0

.post-info
	display: flex
	justify-content: center
	align-items: center
	flex-direction: column
	box-sizing: inherit
	border-bottom: 1px solid #ccc
	padding: 10px

.post-data,
.post-author
	margin: 0 10px
	color: #9a9a9a

.post-image
	margin-top: 20px
	width: 100%
	height: auto

.post-feedback
	width: 60%
	margin:
	top: 30px
	right: auto
	left: auto
	border-top: 1px solid rgba(#000, 0.1)
	padding-top: 15px

.post-feedback a
	padding:
	left: 5px
	right: 5px
	color: #46b784
	text-decoration: none
	transition: color 0.4s ease
	&:hover,
	&:active
		color: darken(#46b784, 20%)

@media (min-width: 768px)
	.post
		width: 600px
		margin: auto

	.post-info
		flex-direction: row
</style>