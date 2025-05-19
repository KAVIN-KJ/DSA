module FullAdder (
    input wire a,b,cin,output wire sum,cout
);

    assign sum = a^b^cin;
    assign cout = a&b | b&cin | cin&a;
    
endmodule


module TB;
    
    reg a,b,ci;
    wire s,co;

    FullAdder uut(.a(a),.b(b),.cin(ci),.sum(s),.cout(co));

    initial begin
        a=0;b=0;ci=0;#10;
        a=0;b=0;ci=1;#10;
        a=0;b=1;ci=0;#10;
        a=0;b=1;ci=1;#10;

        a=1;b=0;ci=0;#10;
        a=1;b=0;ci=1;#10;
        a=1;b=1;ci=0;#10;
        a=1;b=1;ci=1;#10;
    end

    initial begin
        $dumpfile("outputwave.vcd");
        $dumpvars(0,TB);
    end


endmodule

