import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.*;
public class IntrestCal extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException  
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
         String s=req.getParameter("compund");
         String[] s1=s.split(",");
         double p=Double.parseDouble(req.getParameter("P"));
        double r=Double.parseDouble(req.getParameter("rate"));
        int y=Integer.parseInt(req.getParameter("year"));
        int m=Integer.parseInt(req.getParameter("month"));
        double n=Double.parseDouble(s1[0]);
        
        //float A=(1+math.pow(r/n*100),n*t);
        double t=y+(m/12);
        double CI =p*(Math.pow((1 + r / (100*n)), n*t));
        double ca=CI-p;
        out.println("<html><body><h2>Principle Amount :"+p+"</h2></body></html>");
        out.println("<html><body><h2>Rate :"+r+"</h2></body></html>");
        out.println("<html><body><h2>Year "+y+" and  month is "+m+"</h2></body></html>");
        out.println("<html><body><h2>Compounded Interest base on "+s1[1]+" A :"+CI+"</h2></body></html>");
        out.println("<html><body><h2>Compounded Interest :"+ca+"</h2></body></html>");
        out.flush();
//       For example, If Mohan deposits Rs. 4000 into an account paying 6% annual interest compounded quarterly, and then the money will be in his account after five years can be calculated as:
// Substituting, P = 4000, r = 0.06, n = 4, and t = 5 in A = A = P(1 + r/n){nt}, we get A = Rs. 5387.42
    }
}