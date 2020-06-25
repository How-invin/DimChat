import 'package:flutter/material.dart';
import 'package:dim_chat_client/Themes.dart';
import 'package:dim_chat_client/ui/Login.dart';
void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  static final appName = 'DimChat';
  // This widget is the root of your application.
  @override 
  Widget build(BuildContext context) {
    return MaterialApp(
      title: appName,
      theme: Themes.defaultTheme(),
      home: LoginPage(),
    );
  }
}


