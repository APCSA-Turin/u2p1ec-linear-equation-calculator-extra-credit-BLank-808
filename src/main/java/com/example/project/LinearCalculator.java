package com.example.project;
public class LinearCalculator{
    //FOR EXTRA CREDIT 
    //you should copy and paste all of your code from the LinearCalculator class
    // but NOT printInfo(). Please update it below
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
int x1;
int x2;
int y1;
int y2;
double Mx;
double My;
    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String point1, String point2){ // <--add 2 string parameters to this constructor
        int l1=point1.indexOf(",");
        int l2=point2.indexOf(",");
x1=Integer.valueOf(point1.substring(1,l1));
x2=Integer.valueOf(point2.substring(1,l2));
y1=Integer.valueOf(point1.substring(l1+1, point1.indexOf(")")));
y2=Integer.valueOf(point2.substring(l2+1, point2.indexOf(")")));

    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public void setX1(int newx){x1=newx;}
    public void setY1(int newy){y1=newy;}
    public void setX2(int newx){x2=newx;}
    public void setY2(int newy){y2=newy;}


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        double result=Math.pow(Math.pow(x2-x1, 2)+(Math.pow(y2-y1, 2)),0.5);
        result*=100;
        result=Math.round(result);
        return result/100.0;
    }
    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        if (slope()==-999.99){
            return -999.99;
           }
        double yInt;
        if (x1==0){ return y1;} else if (x2==0){return y2;}
        double result=y1-(x1*slope());
        yInt=Math.round(result *100);
        return yInt/100.0;
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        
        if (x2-x1==0){ return -999.99;}
        double result=(double)(y2-y1)/(x2-x1);
        return ((Math.round((result*100)))/100.0);
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
           if (slope()==-999.99){
            return "undefined";
           }
           if (slope()==0.0){
            return "y=" + yInt();
           }
           if (yInt()==0){
            return "y=" + slope()+"x";
           }
           if (yInt()<0){
            return "y=" + slope()+"x"+yInt();
           }
        return "y=" + slope()+"x+"+yInt();
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        return ((int)(x*100+0.5))/100.0;
    }

    //printInfo() -> returns a string of information
    //this method is tested but you can also call it in your main method if gradle tests are 
    //not working. 
    //You will need to concatenate to the string 
    //the results from findSymmetry() and Midpoint()

    public String printInfo(){
        String studentOutput = "The two points are: (" + getX1() + "," + getY1() + ")";
        studentOutput += " and " + "(" + getX2() + "," + getY2() + ")";
        studentOutput += "\nThe equation of the line between these points is: " + equation();
        studentOutput += "\nThe slope of this line is: " + slope();
        studentOutput += "\nThe y-intercept of the line is: " + yInt();
        studentOutput += "\nThe distance between the two points is: " + distance();
        studentOutput += "\n"+findSymmetry();
        studentOutput += "\n"+Midpoint();
        return studentOutput;
    }

    //findSymmetry()-> returns a string 
    //the method should determine if there is symmetry between the two points
    // there should be  4 return statements 
    // return "Symmetric about the x-axis";
    // return "Symmetric about the y-axis";
    //return "Symmetric about the origin";
    //return "No symmetry";
    public String findSymmetry(){
        setmidpoint();
        System.out.println(Mx+""+My);
        if (y1==y2)
        { return "Symmetric about the y-axis";}
        if(x1==x2){ return "Symmetric about the x-axis";}
        if ((Mx==0.0)&&(My==0.0)){return "Symmetric about the origin";}
    return "No symmetry";
    }

    //Midpoint()->return a string 
    //the method should calculate the midpoint between the two points
    //it should return "The midpoint of this line is: (0,0)";
    public String Midpoint(){
        setmidpoint();
        return "The midpoint of this line is: "+"("+Mx+","+My+")";
    }
    public void setmidpoint(){
        Mx=x1+((x2-x1) / 2.0);
        My=(slope()*Mx)+yInt();
        if(x1==x2){Mx=x1; My=0;}
    }

}



