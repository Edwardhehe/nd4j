package org.nd4j.autodiff.tensorgrad;

import lombok.AllArgsConstructor;
import org.nd4j.autodiff.ArrayFactory;
import org.nd4j.autodiff.ArrayField;
import org.nd4j.autodiff.functions.DifferentialFunctionFactory;
import org.nd4j.autodiff.graph.Graph;
import org.nd4j.autodiff.opstate.NDArrayInformation;
import org.nd4j.autodiff.opstate.NDArrayVertex;
import org.nd4j.autodiff.opstate.OpState;
import org.nd4j.autodiff.tensorgrad.impl.TensorGradVariable;
import org.nd4j.linalg.api.ndarray.INDArray;

/**
 * Created by agibsonccc on 4/9/17.
 */
@AllArgsConstructor
public class TensorGrad {
    private TensorGradGraph graph = new TensorGradGraph();
    private ArrayFactory arrayFactory = new ArrayFactory(graph);
    private DifferentialFunctionFactory<ArrayField> arrayFieldDifferentialFunctionFactory;

    private TensorGrad() {
        graph = new TensorGradGraph();
        arrayFactory = new ArrayFactory(graph);
        arrayFieldDifferentialFunctionFactory = new DifferentialFunctionFactory<>(graph,arrayFactory);
    }

    public TensorGradGraph graph() {
        return graph;
    }

    public static TensorGrad create() {
        return new TensorGrad();
    }



    public  TensorGradVariable var(String name, INDArray arr) {
        NDArrayInformation ndArrayInformation = NDArrayInformation.builder()
                .shape(arr.shape()).id(name).build();
        NDArrayVertex ndArrayVertex = new NDArrayVertex(graph.numVertices(),ndArrayInformation);
        ArrayField arrayField = new ArrayField(ndArrayVertex,graph);
        return  TensorGradVariable.builder()
                .tensorGrad(this).
                        arrayField(arrayFieldDifferentialFunctionFactory.var(name,arrayField))
                .varName(name)
                .arr(arr).build();

    }


    public TensorGradVariable grad(TensorGradVariable iX,TensorGradVariable wrt) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(iX.getArrayField().diff(wrt.getArrayField()))
                .varName("grad(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }


    public TensorGradVariable neq(TensorGradVariable iX,TensorGradVariable iy) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.neq(iX.getArrayField(),iy.getArrayField()))
                .varName("neq(" + iX.getVarName() + "," + iy.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable eq(TensorGradVariable iX,TensorGradVariable iy) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.eq(iX.getArrayField(),iy.getArrayField()))
                .varName("eq(" + iX.getVarName() + "," + iy.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable or(TensorGradVariable iX,TensorGradVariable iy) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.or(iX.getArrayField(),iy.getArrayField()))
                .varName("or(" + iX.getVarName() + "," + iy.getVarName() + ")").tensorGrad(this)
                .build();
    }


    public TensorGradVariable cos(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.cos(iX.getArrayField()))
                .varName("cos(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable sin(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.sin(iX.getArrayField()))
                .varName("sin(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable tan(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.tan(iX.getArrayField()))
                .varName("tan(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable acos(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.acos(iX.getArrayField()))
                .varName("acos(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable asin(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.asin(iX.getArrayField()))
                .varName("asin(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable atan(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.atan(iX.getArrayField()))
                .varName("atan(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable cosh(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.cosh(iX.getArrayField()))
                .varName("cosh(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable sinh(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.sinh(iX.getArrayField()))
                .varName("sinh(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable tanh(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.tanh(iX.getArrayField()))
                .varName("tanh(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable acosh(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.acosh(iX.getArrayField()))
                .varName("acosh(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable asinh(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.asinh(iX.getArrayField()))
                .varName("asinh(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable atanh(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.atanh(iX.getArrayField()))
                .varName("atanh(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable exp(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.exp(iX.getArrayField()))
                .varName("exp(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable log(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.log(iX.getArrayField()))
                .varName("log(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable pow(TensorGradVariable iX,  TensorGradVariable i_y) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.pow(iX.getArrayField(),null))
                .varName("pow(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable sqrt(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.sqrt(iX.getArrayField()))
                .varName("sqrt(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable square(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.square(iX.getArrayField()))
                .varName("square(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable floor(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.floor(iX.getArrayField()))
                .varName("floor(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable relu(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.relu(iX.getArrayField()))
                .varName("relu(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable softmax(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.softmax(iX.getArrayField()))
                .varName("softmax(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable hardTanh(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.hardTanh(iX.getArrayField()))
                .varName("hardTanh(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable hardTanhDerivative(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.hardTanhDerivative(iX.getArrayField()))
                .varName("hardTanhDerivative(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable sigmoid(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.sigmoid(iX.getArrayField()))
                .varName("sigmoid(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable sigmoidDerivative(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.sigmoidDerivative(iX.getArrayField()))
                .varName("sigmoidDerivative(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable sign(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.sign(iX.getArrayField()))
                .varName("sign(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable softsign(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.softsign(iX.getArrayField()))
                .varName("softsign(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable softsignDerivative(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.softsignDerivative(iX.getArrayField()))
                .varName("softsignDerivative(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable softplus(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.softplus(iX.getArrayField()))
                .varName("softplus(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable elu(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.elu(iX.getArrayField()))
                .varName("elu(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable eluDerivative(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.eluDerivative(iX.getArrayField()))
                .varName("eluDerivative(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable leakyRelu(TensorGradVariable iX, double cutoff) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.leakyRelu(iX.getArrayField(),cutoff))
                .varName("leakyRelu(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable leakyReluDerivative(TensorGradVariable iX, double cutoff) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.leakyReluDerivative(iX.getArrayField(),cutoff))
                .varName("leakyReluDerivative(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }



    public TensorGradVariable mean(TensorGradVariable iX) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.mean(iX.getArrayField()))
                .varName("mean(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }


    public TensorGradVariable standardDeviation(TensorGradVariable iX,
                                                boolean biasCorrected,
                                                int...dimensions) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.std(
                        iX.getArrayField(),
                        biasCorrected ,
                        dimensions))
                .varName("variance(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable variance(TensorGradVariable iX,
                                       boolean biasCorrected,
                                       int...dimensions) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.variance(iX.getArrayField(),
                        biasCorrected ,
                        dimensions))
                .varName("variance(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable sum(TensorGradVariable iX,
                                  int...dimensions) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.sum(iX.getArrayField(),dimensions))
                .varName("sum(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }

    public TensorGradVariable prod(TensorGradVariable iX,
                                   int...dimensions) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.prod(iX.getArrayField(),dimensions))
                .varName("prod(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }


    public TensorGradVariable max(TensorGradVariable iX,int...dimensions) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.max(iX.getArrayField(),dimensions))
                .varName("max(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }


    public TensorGradVariable min(TensorGradVariable iX,
                                  int...dimensions) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.min(iX.getArrayField(),dimensions))
                .varName("min(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }


    public TensorGradVariable reshape(TensorGradVariable iX,
                                      int...shape) {
        return TensorGradVariable.builder()
                .arr(null)
                .differentialFunction(arrayFieldDifferentialFunctionFactory.reshape(iX.getArrayField(),shape))
                .varName("reshape(" + iX.getVarName() + ")").tensorGrad(this)
                .build();
    }
}