import 'package:flutter/material.dart';
import 'package:dim_chat_client/Adapt.dart';
import 'dart:io';

class Login extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        leading: Icon(Icons.account_circle),
        title: Text('DimChat'),
      ) ,
      body: Container(
        color: Theme.of(context).backgroundColor,
        child: LoginPage(),
      ),
      bottomSheet: Container(
        color: Theme.of(context).backgroundColor,
        child: buildBottom(),
      ),
    );
  }
}


class LoginPage extends StatefulWidget {
  @override
  _LoginPageState createState() => new _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisSize: MainAxisSize.max,
      children: <Widget>[

        Image.asset(
          "assets/images/loginPic.jpeg",
          width: Adapt.px(750),
          height: Adapt.px(260),
          fit: BoxFit.cover,
        ),

        Container(height: Adapt.px(50),),

        Center(child: buildForm()),

        Container(height: Adapt.px(50),),

        Center(child: buildButton(),),
      ],
    );
  }

  static bool isShowPassWord = false;
  static bool isGainFocus = true;
  static bool isLogging = false;

  FocusNode _focusNode1 = FocusNode();
  FocusNode _focusNode2 = FocusNode();

  changeLoginStatus(){
    setState(() {
      isLogging = !isLogging;
    });
    
  }
  
  simualteLogin(){
    changeLoginStatus();
    Future.delayed(Duration(seconds: 1), ()=>{changeLoginStatus()});
  }
  //Logic Function
  changeFocus(bool isTrue){
    setState(() {
      isGainFocus = isTrue;
    });
  }
  
  changeShowStatus(){
    setState(() {
      isShowPassWord = !isShowPassWord;
    });
  }



  @override
  void initState() {
    _focusNode1.addListener(() {
      changeFocus(_focusNode1.hasFocus);
    });
    _focusNode2.addListener(() {
      changeFocus(_focusNode2.hasFocus);
    });
    super.initState();
  }

  Widget buildForm() {
      return new Container(
        decoration:
        new BoxDecoration(
          borderRadius: BorderRadius.all(Radius.circular(8))
          , color: Colors.white
        ),
        width: Adapt.px(600),
        height: Adapt.px(260),
    
        child: new Form(
          child: new Column(
            mainAxisSize: MainAxisSize.max,
            children: <Widget>[
    
              Flexible(
                child: Padding(
                  padding: EdgeInsets.all(Adapt.px(25)),
                  child: new TextFormField(
                    focusNode: _focusNode1,
                    decoration: new InputDecoration(
                      icon: new Icon(Icons.email, color: Colors.black,),
                      hintText: "Email Address",
                      border: InputBorder.none
                    ),
                  ),
                ),
              ),
    
              Flexible(
                child: Padding(
                  padding: EdgeInsets.all(Adapt.px(25)),
                  child: new TextFormField(
                    focusNode: _focusNode2,
                    decoration: new InputDecoration(
                      icon: new Icon(Icons.lock, color: Colors.black,),
                      hintText: "Password",
                      border: InputBorder.none,
                      suffixIcon: new IconButton(icon: new Icon(
                        Icons.remove_red_eye, color: Colors.black,),
                        onPressed: changeShowStatus,
                      ),
                    ),
                    obscureText: !isShowPassWord,
                ),
              ),
            ),

          ],
        ),
      ),
    );
  }

  Widget buildButton(){
    if(isGainFocus) return null;
    final buttonPadding = 50;
    return new Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        FlatButton(
          child: Text("立即注册"),
          onPressed: () => {},
        ),
        Padding(
          padding: EdgeInsets.only(left:Adapt.px(buttonPadding),right: Adapt.px(buttonPadding)),
          child: Container(
            width: Adapt.px(180),
            child: buildGo(),
          )
        ),
        FlatButton(
          child: Text("忘记密码"),
          onPressed: () => {},
        ),
      ],
    );
  }

  Widget buildGo(){
    if(isLogging){
      return RaisedButton(
        child: Text("登录中..."),
        color: Colors.white10,
      );
    }
    return Padding(
      padding: EdgeInsets.only(left:Adapt.px(30),right: Adapt.px(30)),
      child: RaisedButton(
        child: Text("GO"),
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(25),),
        color: Colors.red,
        onPressed:simualteLogin,
      ),
    );
  }

}

Widget buildBottom(){
  return new Row(
    mainAxisAlignment: MainAxisAlignment.spaceBetween,
    mainAxisSize: MainAxisSize.max,
    children: <Widget>[
      FlatButton(
        child: Text("More"),
        onPressed: () => {},
      ),
      FlatButton(
        child: Text("Exit"),
        onPressed: () => exit(0),
      ),
    ],
  );
}

