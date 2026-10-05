<template>
  <div class="component-card list-container">
    <h3>2. LocDoc Kafka Consumer & Storage Tier</h3>
    <p class="subtitle">This component polls the database to display messages consumed from Kafka and saved via Hibernate.</p>
    
    <div v-if="messages.length === 0" class="no-data">
      No messages detected in database yet. Use the form above to publish some!
    </div>
    
    <ul v-else class="message-list">
      <li v-for="msg in messages" :key="msg.id" class="message-item">
        <span class="msg-id">#{{ msg.id }}</span>
        <span class="msg-text">{{ msg.content }}</span>
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'MessageList',
  data() {
    return {
      messages: []
    };
  },
  mounted() {
    // Fetch immediately on load
    this.fetchMessages();
    // Poll the database every 2 seconds to keep the UI fresh and real-time
    this.pollingInterval = setInterval(this.fetchMessages, 2000);
  },
  beforeUnmount() {
    // Clear interval when component is destroyed to prevent memory leaks
    clearInterval(this.pollingInterval);
  },
  methods: {
    async fetchMessages() {
      try {
        const response = await axios.get('http://localhost:8080/api/messages');
        this.messages = response.data;
      } catch (error) {
        console.error("Error fetching messages:", error);
      }
    }
  }
};
</script>

<style scoped>
.list-container {
  border-left: 4px solid #35495e;
  margin-top: 20px;
}
.no-data {
  color: #777;
  font-style: italic;
  margin-top: 15px;
}
.message-list {
  list-style: none;
  padding: 0;
  margin-top: 15px;
  max-height: 250px;
  overflow-y: auto;
}
.message-item {
  background: #f9f9f9;
  padding: 10px;
  border-bottom: 1px solid #eee;
  display: flex;
  gap: 15px;
}
.msg-id {
  font-weight: bold;
  color: #35495e;
}
.msg-text {
  color: #333;
}
</style>