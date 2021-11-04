<template>
  <div class="container">
    <div class="row">
      <div class="col-md-4 mt-5">
        <div class="list-group">
          <book-component></book-component>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import BookComponent from '@/components/BookComponent.vue'

  export default {
    name: 'Book',
    components: {
      BookComponent
    }
  }
</script>
