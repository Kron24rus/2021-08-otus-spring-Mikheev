<template>
  <div class="container">
    <div class="row">
      <div class="col-md-4 mt-5">
        <div class="list-group">
          <author-component></author-component>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import AuthorComponent from '@/components/AuthorComponent.vue'

  export default {
    name: 'Author',
    components: {
      AuthorComponent
    }
  }
</script>
