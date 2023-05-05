import React from 'react';
import styled from 'styled-components';
import { TailSpin } from 'react-loader-spinner';

const LoadingWrapper = styled.div`
    display: flex;
    justify-content: center;
    width: 100%;
    margin-top: 3vh;
    flex-direction: column;
    align-items: center;
`;

const LoadingText = styled.p`
    font-size: 2rem;
    color: white;
`;

function LoadingComponent() {
  return (
    <LoadingWrapper>
      <TailSpin color="white" height={80} width={80} />
      <LoadingText>Loading...</LoadingText>
    </LoadingWrapper>
  );
}

export default LoadingComponent;