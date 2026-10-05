<template>
  <div class="dashboard-wrapper">
    <h2>Enterprise System Dashboard</h2>
    <p class="desc">A full-stack asynchronous processing simulation environment.</p>
    <hr />
    <MessageForm />
    <MessageList />
  </div>
</template>

<script>
import MessageForm from './MessageForm.vue';
import MessageList from './MessageList.vue';

export default {
  name: 'Dashboard',
  components: {
    MessageForm,
    MessageList
  }
};
</script>

<style scoped>
.dashboard-wrapper {
  background: white;
  padding: 25px;
  border-radius: 8px;
  box-shadow: 0 4px 15px rgba(0,0,0,0.05);
}
h2 {
  margin-bottom: 5px;
  color: #2c3e50;
}
.desc {
  color: #666;
  font-size: 14px;
  margin-bottom: 20px;
}
hr {
  border: 0;
  height: 1px;
  background: #eee;
  margin-bottom: 20px;
}
</style>