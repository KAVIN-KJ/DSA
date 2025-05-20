module MUX (
    input wire S0,S1,I0,I1,I2,I3,
    output reg Y
);
// behavioural modelling
    always @(*) begin
        case ({S1,S0})
            2'b00: Y = I0;
            2'b01: Y = I1;
            2'b10: Y = I2;
            2'b11: Y = I3;
            default: Y = 0; 
        endcase
    end
    
    
endmodule

module MUX_TB;

    reg i0,i1,i2,i3,s0,s1;
    wire y;

    MUX uut(
        .S0(s0),
        .S1(s1),
        .I0(i0),
        .I1(i1),
        .I2(i2),
        .I3(i3),
        .Y(y)
    );

    initial begin
        s1 = 0; s0 = 0; i3 = 0; i2 = 0; i1 = 0; i0 = 1; #10;
        s1 = 0; s0 = 1; i3 = 0; i2 = 0; i1 = 1; i0 = 0; #10;
        s1 = 1; s0 = 0; i3 = 0; i2 = 1; i1 = 0; i0 = 0; #10;
        s1 = 1; s0 = 1; i3 = 1; i2 = 0; i1 = 0; i0 = 0; #10;
        $finish;
    end
    initial begin        
        $dumpfile("outputwave.vcd");
        $dumpvars(0,MUX_TB);
    end
    initial begin
        $monitor("Select Line = %b %b Input = %b %b %b %
        
        
        b output = %b",s1,s0,i3,i2,i1,i0,y);
    end
    
endmodule