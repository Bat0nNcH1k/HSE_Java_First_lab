public class Complex {
    double real;
    double image;

    public Complex() {
        this(0, 0);
    }

    public Complex(double real, double image) {
        this.real = real;
        this.image = image;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImage() {
        return image;
    }

    public void setImage(double image) {
        this.image = image;
    }

    public Complex sumComplex(Complex a){
        double real1 = a.getReal();
        double image1 = a.getImage();
        double newReal = real1 + this.real;
        double newImage = image1 + this.image;
        return new Complex(newReal, newImage);
    }

    public Complex multiComplex(Complex a){
        double real1 = a.getReal();
        double image1 = a.getImage();
        double newReal = real1 * this.real - image1 * this.image;
        double newImage = image1 * this.real + real1 * this.image;
        return new Complex(newReal, newImage);
    }

    public void print(){
        if(image > 0){System.out.println(real + " + " + image + "i");}
        else if(image < 0){System.out.println(real + "" + image + "i");}
        else{System.out.println(real);}
    }
}
