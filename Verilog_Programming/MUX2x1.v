module MUX (
    input wire A,
    input wire B,
    input wire S,
    output wire Y
);

    assign Y = S ? B : A;
    
endmodule

module MUX_TB;

    reg a,b,s;
    wire y;
    MUX uut(.A(a),.B(b),.S(s),.Y(y));

    initial begin
        s=0;a=0;b=0; #10;
        s=0;a=0;b=1; #10;
        s=0;a=1;b=0; #10;
        s=0;a=1;b=1; #10;
        s=1;a=0;b=0; #10;
        s=1;a=0;b=1; #10;
        s=1;a=1;b=0; #10;
        s=1;a=1;b=1; #10;
        $finish;
    end
    initial begin
        $dumpfile("outputwave.vcd");
        $dumpvars(0,MUX_TB);
    end
    initial begin
        $monitor("S = %b A = %b B = %b Y = %b Time = %t",s,a,b,y,$time);
    end


endmodule