<template>
  <div>
    <InputName @nameChanged="nameChangedHandler" />
    <br />
    <h3>App 데이터: {{ parentName }}</h3>
  </div>
</template>

<script>
import CheckboxItem from './components/CheckboxItem.vue';
import InputName from './components/InputName.vue';

export default {
  components: { InputName, CheckboxItem },
  name: 'App',
  data() {
    return {
      parentName: '',
    };
  },
  methods: {
    nameChangedHandler(e) {
      this.parentName = e.name;
    },
  },
};
</script>
