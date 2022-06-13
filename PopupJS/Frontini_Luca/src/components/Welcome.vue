<template>

<div class="LoginPopUp">
    
    
  <div class="inner">
    <h1 class="value">LOGGED IN</h1>
    <p class="value"> name: {{fields.name}}</p>
        <p class="value">authorities: {{fields.auth}}</p>
    <p class="value">token: {{fields.token}}</p>

  </div>
  </div>
</template>

<script>


export default {
    props:["fields"],
    watch:{
        fields: function(newVal,oldVal){
            this.SetFields(newVal);
            }
    },
    data(){
        return{
            name:null,
            token:null,
            auth:null,
        }
    },
    methods:{
        SetFields(fields){
            this.name=fields.name;
            this.auth=fields.auth;
            this.token=fields.token;
        },
    },
}


</script>

<style>
.value{
    color: yellowgreen;
    border: 2px solid yellowgreen;
    margin: 4px;
    background-color: rgb(77, 71, 71);
    width:100%;
    text-align: center;
    
}

.LoginPopUp{
position:absolute;
left:50%;
top:50%;
transform: translate(-50%,-50%);
display: flex;
align-items: center;
border:4px solid  greenyellow;
justify-content: center;
}

.error{
    color: red;
    border: 2px solid red;
    margin: 4px
}

.inner{
    align-items: center;
    margin:4px;
    flex-direction: column;
    display: flex;
}  



</style>