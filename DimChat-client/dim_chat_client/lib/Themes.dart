import 'package:flutter/material.dart';

class Themes{
  static defaultTheme(){
    return ThemeData(
      primaryColor: Colors.blue,
      accentColor: Colors.green,
      backgroundColor: Colors.blue,
      textTheme: TextTheme(bodyText2: TextStyle(color: Colors.purple)),
    );
  }
}