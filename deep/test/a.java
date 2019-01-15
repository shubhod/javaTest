class a
{
   protected int a;
   a()
    {
        a=0;
    }
}
class b extends a
{


}
class c
{
    public static void main()
    {
            b b1=new b();
            b1.a=3;

    }
}
