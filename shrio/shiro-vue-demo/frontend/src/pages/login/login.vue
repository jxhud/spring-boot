<template>
  <div class="bg">
    <Card style="margin:auto;top: 200px; width: 600px;height: 350px;border-radius: 10px">
      <Tabs value="name1">
        <TabPane label="登录" name="name1">
          <div style="margin-top: 20px;">
            <Form ref="formInline" :model="formInline" :rules="ruleInline" :label-width="75">
              <FormItem prop="user" label="用户名" >
                <Input type="text" v-model="formInline.userName" placeholder="Username"/>
              </FormItem>
              <FormItem prop="password" label="密码">
                <Input type="password" v-model="formInline.password" placeholder="Password"/>
              </FormItem>
              <Checkbox style="margin-left:23px;margin-bottom: 10px">记住我</Checkbox>
              <FormItem>
                <Button type="primary" @click="handleSubmit('formInline')" style="width: 80%">登录</Button>
              </FormItem>
            </Form>
          </div>
        </TabPane>
        <TabPane label="注册" name="name2">
          <div style="margin-top: 20px;">
            <Form ref="formInline" :model="formInline" :rules="ruleInline" :label-width="75">
              <FormItem prop="user" label="用户名" >
                <Input type="text" v-model="formInline.userName" placeholder="Username"/>
              </FormItem>
              <FormItem prop="password" label="密码">
                <Input type="password" v-model="formInline.password" placeholder="Password"/>
              </FormItem>
              <FormItem prop="password" label="确认密码">
                <Input type="password" v-model="formInline.password" placeholder="Password"/>
              </FormItem>
              <FormItem>
                <Button type="primary" @click="handleSubmit('formInline')" style="width: 80%">注册</Button>
              </FormItem>
            </Form>
          </div>
        </TabPane>
      </Tabs>
    </Card>
  </div>
</template>

<script>
  import http from '../../components/http'
  export default {
    data () {
      return {
        formInline: {
          userName: 'suyu',
          password: '123456',
          rememberMe: false

        },
        ruleInline: {
          userName: [
            { required: true, message: 'Please fill in the user name', trigger: 'blur' }
          ],
          password: [
            { required: true, message: 'Please fill in the password.', trigger: 'blur' },
            { type: 'string', min: 6, message: 'The password length cannot be less than 6 bits', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      handleSubmit(name) {
        this.$refs[name].validate((valid) => {
          if (valid) {
            http.post("/login/in",this.formInline).then((res)=> {
              if (res.code === 100) {
                this.$Message.success('登录成功');
                this.$router.push({path: '/'});
              } else if (res.code === 101) {
                this.$Message.error('用户名或密码错误')
              }
            })
          }
        })
      }
    }
  }
</script>

<style scoped>
  .input {
    width: 260px !important;
  }
  .bg {
    background: url("../../../static/login.jpg") no-repeat center center fixed;
    background-size: 100% 100%;
    position:absolute;
    width: 100%;
    height: 100%;
    z-index:999999999999;
  }
</style>
